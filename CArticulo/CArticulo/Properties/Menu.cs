using System;

namespace CArticulo {
    class Menu {

        public static int menuOpt(int op) {

            Console.WriteLine ("Seleccione una opción:");
            Console.WriteLine ("0-Salir");
            Console.WriteLine ("1-Nuevo");
            Console.WriteLine ("2-Editar");
            Console.WriteLine ("3-Consultar");
            Console.WriteLine ("4-Eliminar");
            Console.WriteLine ("5-Listar");
            switch (op) {
                case 0:
                    break;

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

            }
            return op;
        }
        public static int read(string label) {
            while (true) {
                Console.WriteLine ("Escribe una opción:");
                Console.ReadLine ();
            }

        }
    }

}