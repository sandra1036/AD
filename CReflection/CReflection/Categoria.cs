using System;
namespace CReflection {
    public class Categoria {

        public Categoria(ulong id,string nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        //public ulong Id { get; set; }//hacer una propìerty la manera más corta
        //public string Nombre { get; set; }

        private ulong id;//se puede encapsular con alt + enter (lo hace solo)
        private string nombre;

        public ulong Id {
            get { return id; }
            set { id = value; }
        }
        public string Nombre {
            get { return nombre; }
            set { nombre = value; }
        }

    }
}
