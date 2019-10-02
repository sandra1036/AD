using System;

namespace CPrueba{

    class MainClass {



        //pruebas
        public static int readInteger(string label) {

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
