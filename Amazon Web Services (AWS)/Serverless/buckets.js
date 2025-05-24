'use strict';

const AWS = require('aws-sdk')
const s3 = new AWS.S3()

module.exports.handle = async (event) => {
  return s3.listBuckets().promise()
};