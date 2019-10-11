using System;
using System.Data;

namespace Serpis.Ad {

    public class DbCommandHelper {

        public static void AddParameter(IDbCommand dbCommand, string name, object value) {

            IDbDataParameter dbDataParameter = dbCommand.CreateParameter ();
            dbDataParameter.ParameterName = name;
            dbDataParameter.Value = value; //"cat. 33"
            dbCommand.Parameters.Add (dbDataParameter);

        }
        public static int ReadInteger(string label) {

            while (true) {
                Console.Write (label);
                string linea = Console.ReadLine ();
                Console.WriteLine ();

                try {
                    return Int32.Parse (linea);

                }
                catch {
                    Console.WriteLine ("Formato invalido");
                }
            };
        }
        public static int readOption(String label, string op) {
            while (true) {
                Console.WriteLine (label);
                string opt = Console.ReadLine ();
            }


        }

    }
}