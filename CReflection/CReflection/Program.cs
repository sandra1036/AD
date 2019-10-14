using System;
using System.Reflection;

namespace CReflection {
    class MainClass {
        public static void Main(string[] args) {
            Categoria categoria = new Categoria (5,"Cat 5");
            //Console.WriteLine ("c.Id={0},c.Nombre={1}",categoria.Id,categoria.Nombre);
            ShowPropierty  (categoria,"Id","Nombre");
        }
        public static void ShowPropierty(object obj) {
            Type type= obj.GetType ();
            Console.WriteLine ("obj.GetType()={0}",type);
            foreach(PropertyInfo propertyInfo in type.GetProperties ()) {
                Console.WriteLine ("propertyInfo.Name={0} propertyInfo.GetValue={1}",
                propertyInfo.Name,propertyInfo.GetValue(obj));
            }
        }
        public static void ShowPropierty(object obj,params string[] propiertyNames) {
            Type type = obj.GetType ();
            Console.WriteLine ("obj.GetType()={0}", type);
            foreach (string propertyName in propiertyNames) {
                Console.WriteLine ("propiertyName={0} Value={1}",
                propertyName, obj.GetType().GetProperty(propertyName).GetValue(obj));
            }
        }
    }
}
