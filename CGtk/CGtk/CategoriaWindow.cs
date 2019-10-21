using System;
using System.Data;
using Serpis.Ad;
namespace CGtk {
    public partial class CategoriaWindow : Gtk.Window {
        public CategoriaWindow(object id) :base (Gtk.WindowType.Toplevel) {
                this.Build ();

            //dbConnection nueva, la que tengo en MainWindow?



            entryNombre.Text = nombre;
            buttonAceptar.Clicked +=(sender, e) => {
                nombre = entryNombre.Text;
                //String nombre = entryNombre.Text;
                //IDbCommand dbCommand = dbConnection.CreateCommand ();
                //dbCommand.CommandText = "insert into categoria(nombre) values (@nombre)";
                //DbCommandHelper.AddParameter (dbCommand, "nombre", nombre);
                //dbCommand.ExecuteNonQuery();

                dbCommand.CommandText = "update categoria set nombre=@nombre where id=@id";
                DbCommandHelper.AddParameter (dbCommand, "nombre", nombre);
                dbCommand.ExecuteNonQuery ();

                Destroy ();



            };
            buttonCancel.Clicked += (sender, e) => Destroy();


            }
            


    }
 }

