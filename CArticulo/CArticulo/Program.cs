using System;
using System.Data;
using MySql.Data.MySqlClient;

namespace CArticulo {

    class MainClass {
        private static IDbConnection dbConnection = new MySqlConnection (
             "server=localhost;database= dbprueba; User=root; Password=sistemas;ssl-mode=none"
         );


        public static void Main(string[] args) {

            Console.WriteLine ("Acceso a dbprueba");
            Show ();

        }

        public static void Show() {

            IDbCommand dbCommand = dbConnection.CreateCommand ();

            dbCommand.CommandText = "select * from articulo";

            IDataReader dataReader = dbCommand.ExecuteReader ();

            while (dataReader.Read ()) {

                Console.WriteLine ("id={0} nombre={1} precio={2} categoria={3}",dataReader["id"],dataReader["nombre"],dataReader["precio"],dataReader["categoria"]);

            }

            dataReader.Close ();

        }


    }

  }


