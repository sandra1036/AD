﻿using System;
using System.Data;

namespace Serpis.Ad {
    public class App {
           private static App instance = new App ();
           
            private App() {

            }
            
            public static App Intance { get { return instance; } }

            private IDbConnection dbConnection;
            public IDbConnection DbConnection { 
                get { return dbConnection; } 
                set { dbConnection = value; }
        }
    }
}
