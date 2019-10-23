using System;
using System.Data;
using MySql.Data.MySqlClient;
using Gtk;
using CGtk;
using Serpis.Ad;
using System.Collections.Generic;
using System.Reflection;

/*Modelo-> Categoria -> id,nombre
  CategoriaDao -> Acceso a Datos (insertar,modificar...)
  Una clase para la conexión*/

public partial class MainWindow : Gtk.Window {
    public MainWindow() : base (Gtk.WindowType.Toplevel) {

        Build ();

        App.Intance.DbConnection = new MySqlConnection ("server=localhost;database= dbprueba; " +
            "User=root; Password=sistemas;ssl-mode=none");

        App.Intance.DbConnection.Open ();




        //treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
        //treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

        //categorias.Add (new Categoria (1, "cat 1"));
        //categorias.Add (new Categoria (2, "cat 2"));
        //categorias.Add (new Categoria (3, "cat 3"));


        TreeViewHelper.Fill (treeView, new string[] { "Id", "Nombre" }, CategoriaDao.GetAll());

        newAction.Activated += (sender, e) => {
            Categoria categoria = new Categoria ();
            new CategoriaWindow (categoria);

        };

        editAction.Activated += (sender, e) => {
            object id = TreeViewHelper.GetId (treeView);
            Categoria categoria = CategoriaDao.Load(id);
            new CategoriaWindow (categoria);


            //Console.WriteLine ("editAction Activated Name = " + value);

        };
        refreshAction.Activated += (sender, e) =>
            TreeViewHelper.Fill (treeView, new string[] { "Id", "Nombre" }, CategoriaDao.GetAll ());

        refreshStateActions ();
        treeView.Selection.Changed += (sender, e) => refreshStateActions ();
    }





    protected void OnDeleteEvent(object sender, DeleteEventArgs a) {
        Application.Quit ();
        a.RetVal = true;
    }

    private void refreshStateActions() {

        bool hasSelectedRows=treeView.Selection.CountSelectedRows() > 0;
        editAction.Sensitive = hasSelectedRows;
        deleteAction.Sensitive = hasSelectedRows;
    }

}
