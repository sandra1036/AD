using System;
using System.Data;
using MySql.Data.MySqlClient;
using Serpis.Ad;

namespace CMySql
{
    class MainClass
    {
      private static IDbConnection dbConnection = new MySqlConnection(
               "server=localhost;database= dbprueba; User=root; Password=sistemas;ssl-mode=none"
           );

        public static void Main(string[] args)
        {

            Console.WriteLine("Acceso a dbprueba");
           

            dbConnection.Open();
            Insert();
            showAll();
            ShowMetaInfo ();

            dbConnection.Close();


        }
        public static void showAll(){

            IDbCommand dbCommand = dbConnection.CreateCommand();

            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader();

            while (dataReader.Read()){
                Console.WriteLine("id={0} nombre={1}", dataReader["id"], dataReader["nombre"]);

            }
            dataReader.Close();

        }
       public static void Insert(){

            IDbCommand dbCommand = dbConnection.CreateCommand();
            //string nombre = "nuevo" + DateTime.Now;
            Console.Write("Nombre: ");
            string nombre=Console.ReadLine(); 
            dbCommand.CommandText = "insert into categoria(nombre) values (@nombre)";

            //IDbDataParameter dbDataParameter = dbCommand.CreateParameter ();
            //dbDataParameter.ParameterName = "nombre";
            //dbDataParameter.Value = nombre;//"cat. 33"
            //dbCommand.Parameters.Add (dbDataParameter);

           DbCommandHelper.AddParameter (dbCommand, "nombre", nombre);
            dbCommand.ExecuteNonQuery();

        }
     public static void ShowMetaInfo() {
            IDbCommand dbCommand = dbConnection.CreateCommand ();

            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader ();
            Console.WriteLine ("FieldCount={0}",dataReader.FieldCount);

            for (int i = 0; i < dataReader.FieldCount; i++) {

                Console.WriteLine("Field {0,3}={1,-15} Type={2}",i,dataReader.GetName(i),dataReader.GetFieldType(i));

            }

            dataReader.Close();
        }

    }
}
