const express = require('express')
const bodyParser = require('body-parser')
const app = express()

app.use(bodyParser.urlencoded({ extended: false }))

app.post('/handle-request', (req, res) => {
  const json = req.body.config
  const config = JSON.parse(json) // vulnerable to insecure deserialization

  // Use config object in application logic
  // ...
})