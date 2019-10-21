﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using Serpis.Ad;
namespace CGtk {
    public class CategoriaDao {

        private static string selectAll = "select * from categoria order by id";

            public static IEnumerable GetAll() {
            IList<Categoria> categorias = new List<Categoria> ();

            IDbCommand dbCommand = App.Intance.DbConnection.CreateCommand ();
            dbCommand.CommandText = selectAll;
            IDataReader dataReader = dbCommand.ExecuteReader ();

            while (dataReader.Read ()) {

                //Opción 1

                categorias.Add (new Categoria ((ulong)dataReader["id"], (string)dataReader["nombre"]));

                //Opción 2

                //Categoria categoria = new Categoria ();
                //categoria.Id =(ulong)dataReader["id"];
                //categoria.Nombre = (string)dataReader["nombre"];

                //Opcion 3

                //Type type = typeof (Categoria);
                //Categoria categoria = Activator.CreateInstance<Categoria>();
                //type.GetProperty ("Id").SetValue (categoria, dataReader["id"]);
                //type.GetProperty ("Nombre").SetValue (categoria, dataReader["nombre"]);


                //categorias.Add(categoria);
            }
            dataReader.Close ();
            return categorias;
        }
        private static string select = "update categoria set nombre=@nombre where id=@id";

        public static Load(object id) {
            Categoria categoria = new Categoria ();
            IDbCommand dbCommand = App.Intance.DbConnection.CreateCommand ();
            dbCommand.CommandText = select;
            DbCommandHelper.AddParameter (dbCommand, "id", id);
            IDataReader dataReader = dbCommand.ExecuteReader ();
            dataReader.Read ();
            categoria.Id = (ulong)id;
            categoria.Nombre = (string)dataReader["nombre"];
            dataReader.Close ();
            return categoria;
        }

    }
 }

