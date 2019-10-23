using System;
using System.Data;
using Serpis.Ad;
namespace CGtk {
    public partial class CategoriaWindow : Gtk.Window {
        public CategoriaWindow(Categoria categoria) : base (Gtk.WindowType.Toplevel) {
            this.Build ();

            //dbConnection nueva, la que tengo en MainWindow?



            entryNombre.Text = categoria.Nombre;
            buttonAceptar.Clicked += (sender, e) => {
                categoria.Nombre = entryNombre.Text;
                CategoriaDao.Save (categoria);
                Destroy ();



            };
            buttonCancel.Clicked += (sender, e) => Destroy ();


        }



    }
} 

