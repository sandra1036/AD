﻿using System;
using Gtk;
using System.Collections;

namespace Serpis.Ad {

    public class TreeViewHelper {


        public static void Fill(TreeView treeView, string[] propertyNames, IEnumerable enumerable) {
            if (treeView.Model == null)
                init(treeView, propertyNames);
            ListStore listStore = new ListStore (typeof (object));
            foreach (object obj in enumerable)
                listStore.AppendValues (obj);
            treeView.Model = listStore;
        }

        private static void init(TreeView treeView, string[] propertyNames) {
            CellRendererText cellRendererText = new CellRendererText ();
            foreach (string propertyName in propertyNames)
                treeView.AppendColumn (propertyName, cellRendererText,
                  new TreeCellDataFunc ((tree_column, cell, tree_model, iter) => {
                      //Categoria categoria = (Categoria)listStore.GetValue(iter, 0);
                      //object value = categoria.Id;
                      object obj = tree_model.GetValue (iter, 0);
                      object value = obj.GetType ().GetProperty (propertyName).GetValue (obj);

                      cellRendererText.Text = value.ToString ();
                  })
                );
        }
        public static object GetId(TreeView treeView) {
            return GetValue (treeView, "Id");
        }

        public static object GetValue(TreeView treeView, string propertyName) {
            if (!treeView.Selection.GetSelected (out TreeIter treeIter)) //Ninguna fila seleccionada
                return null;
            object obj = treeView.Model.GetValue (treeIter, 0);
            return obj.GetType ().GetProperty (propertyName).GetValue (obj);
        }

        public static void RemoveColumns(TreeView treeView) {
            foreach (TreeViewColumn treeViewColumn in treeView.Columns)
                treeView.RemoveColumn (treeViewColumn);
            
        }


    }
}