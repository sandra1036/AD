using System;
using Gtk;
using CGtk;
using Serpis.Ad;
using System.Collections.Generic;

/*Modelo-> Categoria -> id,nombre
  CategoriaDao -> Acceso a Datos (insertar,modificar...)
  Una clase para la conexión*/

public partial class MainWindow : Gtk.Window {
    public MainWindow() : base (Gtk.WindowType.Toplevel) {

        Build ();

        IList<Categoria> categorias = new List<Categoria> ();
       

        //treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
        //treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

        categorias.Add (new Categoria (1, "cat 1"));
        categorias.Add (new Categoria (2, "cat 2"));
        categorias.Add (new Categoria (3, "cat 3"));


        TreeViewHelper.Fill (treeView, new string[] { "Id", "Nombre" }, categorias);
        newAction.Activated += (sender, e) => new CategoriaWindow ();
        editAction.Activated += (sender, e) => {
            object value = TreeViewHelper.GetValue (treeView, "Nombre");
            Console.WriteLine ("editAction Activated Name = " + value);

        };
       
        refreshStateActions ();

        treeView.Selection.Changed += (sender, e) => refreshStateActions ();//activa los botones cuando selecionas una fila

        quitAction.Activated += (sender, e) => Application.Quit ();

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
