package com.hzj.chocolate.chocolate.util;

import android.os.AsyncTask;

/**
 * Created by FF on 2015/8/29.
 */
public class MyAsyncTask extends AsyncTask <Void,Void,Void>{

    public MyAsyncTask() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }
}
