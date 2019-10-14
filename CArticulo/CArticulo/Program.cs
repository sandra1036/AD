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
                dbConnection.Close ();

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

            Console.WriteLine ("Añadido Nuevo Articulo");


        }


        public static void editar() {
            Console.WriteLine ("Ha entrado en editar");
            Show ();//Es para mostrar los campos para despues modificar el que quieras
            IDbCommand dbCommand = dbConnection.CreateCommand ();
            Console.WriteLine ("Dime el id para entrar en la fila: ");
            string id = Console.ReadLine ();
            dbCommand.CommandText = "select * from articulo where id=@id";
            DbCommandHelper.AddParameter (dbCommand, "id", id);
            IDataReader dataReader = dbCommand.ExecuteReader ();

            while (dataReader.Read ()) {

                Console.WriteLine ("id={0} nombre={1} precio={2} categoria={3}", dataReader["id"], dataReader["nombre"], dataReader["precio"], dataReader["categoria"]);

            }
            dataReader.Close ();
            Console.WriteLine ("Dime que quieres modificar de la fila: ");
            string mod = Console.ReadLine();
            string nombre, precio, categoria;

            if (mod == "nombre") {
                Console.WriteLine ("Dime el nombre: ");
                nombre = Console.ReadLine ();
                dbCommand.CommandText = "update articulo set nombre=@nombre where id=@id";

                DbCommandHelper.AddParameter (dbCommand, "nombre", nombre);
                dbCommand.ExecuteNonQuery ();
            }
            if (mod == "precio") {
                Console.WriteLine ("Dime el precio: ");
                precio = Console.ReadLine ();
                dbCommand.CommandText = "update articulo set precio=@precio where id=@id";
                DbCommandHelper.AddParameter (dbCommand, "precio", precio);
                dbCommand.ExecuteNonQuery ();

            }
            if (mod == "categoria") {
                Console.WriteLine ("Dime la categoria");
                categoria = Console.ReadLine ();
                dbCommand.CommandText = "update articulo set categoria=@categoria where id=@id";
                DbCommandHelper.AddParameter (dbCommand, "categoria", categoria);
                dbCommand.ExecuteNonQuery ();
            }
            if (mod == "todo") {
                Console.WriteLine ("Dime el nombre: ");
                nombre = Console.ReadLine ();
                Console.WriteLine ("Dime el precio: ");
                precio = Console.ReadLine ();
                Console.WriteLine ("Dime la categoria");
                categoria = Console.ReadLine ();
                dbCommand.CommandText = "update articulo set nombre=@nombre precio=@precio categoria=@categoria where id=@id";
               
                dbCommand.ExecuteNonQuery ();
            }
            dbCommand.ExecuteNonQuery ();


        }

        public static void borrar() {
            Console.WriteLine ("Ha entrado en borrar");
            Show ();
            IDbCommand dbCommand = dbConnection.CreateCommand ();

            Console.WriteLine ("Dime el id de la linea que deseas borrar: ");
            string id=Console.ReadLine();
            dbCommand.CommandText = "delete from articulo where id=@id";
            DbCommandHelper.AddParameter (dbCommand, "id", id);
            dbCommand.ExecuteNonQuery ();

        }

        public static void Show() {

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


