using System;
using Gtk;
using CGtk;

/*Modelo-> Categoria -> id,nombre
  CategoriaDao -> Acceso a Datos (insertar,modificar...)
  Una clase para la conexión*/

public partial class MainWindow : Gtk.Window {
    public MainWindow() : base (Gtk.WindowType.Toplevel) {

        Build ();

        treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
        treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

        ListStore listStore = new ListStore (typeof (string), typeof (string));
        treeView.Model = listStore;

        listStore.AppendValues ("1", "cat 1");
        listStore.AppendValues ("2", "cat 2");

        newAction.Activated += (sender, e) => new CategoriaWindow ();
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
