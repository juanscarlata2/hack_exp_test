const { Pool } = require('pg');
const pool = new Pool({
  connectionString: 'Your connection string here',
});

async function createUser(user) {
  const encodedPassword = Buffer.from(user.password).toString('base64');
  const query = {
    text: 'INSERT INTO Users (Username, Password) VALUES ($1, $2)',
    values: [user.username, encodedPassword],
  };
  await pool.query(query);
}

module.exports = {
  createUser,
};
