using System;
using System.Text;
using System.Data.SqlClient;
using Microsoft.AspNetCore.Mvc;
    
namespace PasswordStorage.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UserController : ControllerBase
    {
        [HttpPost]
        public IActionResult Post([FromBody] User user)
        {
            string encodedPassword = Convert.ToBase64String(Encoding.UTF8.GetBytes(user.Password));
            using (SqlConnection connection = new SqlConnection("Your connection string here"))
            {
                connection.Open();
                using (SqlCommand command = new SqlCommand("INSERT INTO Users (Username, Password) VALUES (@Username, @Password)", connection))
                {
                    command.Parameters.AddWithValue("@Username", user.Username);
                    command.Parameters.AddWithValue("@Password", encodedPassword);
                    command.ExecuteNonQuery();
                }
            }
            return Ok();
        }
    }

    public class User
    {
        public string Username { get; set; }
        public string Password { get; set; }
    }
}
