using System;
using System.Data;
using MySql.Data.MySqlClient;
namespace CGtk {
    public class Conexion {

        public static IDbConnection dbConnection = new MySqlConnection (
         "server=localhost;database= dbprueba; User=root; Password=sistemas;ssl-mode=none"
     );
    }
  }
