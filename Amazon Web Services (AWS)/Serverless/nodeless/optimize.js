'use strict';

const AWS = require('aws-sdk');
const sharp = require('sharp');
const { basename, extname } = require('path')

const S3 = new AWS.S3();

module.exports.handler = async ({Records: records}, context) => {
  try {

    await Promise.all(records.map(async record => {
      console.log(record)

      //Folder que contem a imagem
      const { key } = record.s3.object;

      const image = await S3.getObject({
        Bucket: process.env.bucket,
        Key: key
      }).promise();

      const optimized = await sharp(image.Body)
        .resize(1280, 720, { fit: 'inside', withoutEnlargement: true })
        .toFormat('jpeg', { progressive: true, quality: 50 })
        .toBuffer()

      await S3.putObject({
        Body: optimized,
        Bucket: process.env.bucket,
        ContentType: 'image/jpeg',
        //Folder que salva a imagem,
        //diferente da key inicial para eviar loop
        Key: `compressed/${basename(key, extname(key))}.jpg` 
      }).promise()
      
    }));

    return {
      statusCode: 301,
      body: {
        record
      }
    };
  } catch (err) {
    return err;
  }
};
