using System;
using System.Data;
using MySql.Data.MySqlClient;
using Serpis.Ad;

namespace CArticulo {

    class MainClass {
        private static IDbConnection dbConnection = new MySqlConnection (
             "server=localhost;database= dbprueba; User=root; Password=sistemas;ssl-mode=none"
         );


        public static void Main(string[] args) {
           //int entero = DbCommandHelper.ReadInteger ("Introduce una opción: ");

            Console.WriteLine ("Acceso a dbprueba");
            dbConnection.Open ();
    
            Menu.Create ("Menú Articulo")
                .Add ("1-Nuevo", nuevo)
                .Add ("2-Editar", editar)
                .Add ("3-Borrar", borrar)
                .Add("4-Mostar",Show)
                .ExitWhen ("0-Salir")
                .Loop ();

        }


        public static void nuevo() {

            Console.WriteLine("Ha entrado en nuevo");

            Console.Write("Nombre: ");
            string nombre= Console.ReadLine ();

            Console.Write("Precio: ");
            string precio =Console.ReadLine ();

            Console.Write ("Categoria: ");
            string categoria = Console.ReadLine ();

            IDbCommand dbCommand = dbConnection.CreateCommand ();

            dbCommand.CommandText = "insert into articulo(nombre,precio,categoria) values (@nombre,@precio,@categoria)";
            DbCommandHelper.AddParameter(dbCommand,"nombre",nombre);
            DbCommandHelper.AddParameter (dbCommand, "precio", precio);
            DbCommandHelper.AddParameter (dbCommand, "categoria", categoria);
            dbCommand.ExecuteNonQuery ();
            dbConnection.Close ();
        }


        public static void editar() {

            Console.WriteLine ("Ha entrado en editar");

        }

        public static void borrar() {

            Console.WriteLine ("Ha entrado en borrar");

        }

        public static void Show() {
            Console.WriteLine ("Ha entrado en mostrar");
            IDbCommand dbCommand = dbConnection.CreateCommand ();

            dbCommand.CommandText = "select * from articulo";

            IDataReader dataReader = dbCommand.ExecuteReader ();

            while (dataReader.Read ()) {

                Console.WriteLine ("id={0} nombre={1} precio={2} categoria={3}", dataReader["id"], dataReader["nombre"], dataReader["precio"], dataReader["categoria"]);

            }

            dataReader.Close ();

        }
    }

  }


