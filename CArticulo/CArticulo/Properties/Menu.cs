using System;
using System.Collections.Generic;

namespace CArticulo {
    public class Menu {
        private bool exit = false;
        private IList<String> labels = new List<string> ();
        private IDictionary<string, Action> options = new Dictionary<string, Action> ();

       
        public static Menu Create(string menulabel) {
            return new Menu ();
        }

        public Menu Add(string label,Action action) {
            labels.Add (label);
            string opt = label.Substring(0,1).ToUpper();
            options.Add (opt, action);
            return this;
        }

        public Menu ExitWhen(string label) {
            labels.Add (label);

            string opt = label.Substring (0, 1).ToUpper ();
            options.Add (opt, () => exit = true);
            return this;
        }

        public void Loop() {
            //Console.WriteLine(

            foreach (string label in labels) {

                Console.WriteLine (label);
                string opt = Console.ReadLine ();

                if (options.ContainsKey (opt)) {

                    options[opt] ();

                }else

                    Console.WriteLine ("Opción inválida vuelva a introducir. ");
            }
        }



    }

}