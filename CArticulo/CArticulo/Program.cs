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
            dbConnection.Open ();
            Menu.Create ("Menú Categorias")
                .Add ("1-Nuevo", nuevo)
                .Add ("2-Editar", editar)
                .Add ("3-Borrar", borrar)
                .Add("4-Mostar",Show)
                .ExitWhen ("0-Salir")
                .Loop ();

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
        public static void nuevo() {

            Console.WriteLine ("Ha entrado en en nuevo");

        }


        public static void editar() {

            Console.WriteLine ("Ha entrado en editar");

        }

        public static void borrar() {

            Console.WriteLine ("Ha entrado en borrar");

        }


    }

  }


