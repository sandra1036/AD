using System;
using System.Data;

namespace Serpis.Ad {

    public class DbCommandHelper {

        public static void AddParameter(IDbCommand dbCommand, string name, object value) {

            IDbDataParameter dbDataParameter = dbCommand.CreateParameter ();
            dbDataParameter.ParameterName = name;
            dbDataParameter.Value = value; //"cat. 33"
            dbCommand.Parameters.Add (dbDataParameter);

        }


    }

}
