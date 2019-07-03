/**
 * Copyright Google Inc. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Instant Witnesses is written by Steve Stansbury  for Jason Nelson
 *
 * Created May 25, 2018 by the Buryware.
 */
package com.buryware.firebase.instantwitness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.codec.Base64;
//import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import io.firekast.FKCamera;
import io.firekast.FKCameraFragment;
import io.firekast.FKError;
import io.firekast.FKStream;
import io.firekast.FKStreamer;

public class SplashScreen extends Activity {

    static private Boolean bEULA = true;
    private WebView mWebview;
    private Button mOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        if (bEULA) {
            setContentView(R.layout.activity_eula);

            mWebview = findViewById(R.id.webview);
            mWebview.loadUrl("https://www.iubenda.com/privacy-policy/92163031");
            mWebview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setContentView(R.layout.spashscreen);
                    DoHandleSplash();
                }
            });

            mOk = findViewById(R.id.btn_okay);
            mOk.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setContentView(R.layout.spashscreen);
                    DoHandleSplash();
                }
            });
            bEULA = false;

        } else {
            setContentView(R.layout.spashscreen);
            DoHandleSplash();
        }
    }

    public void DoHandleSplash(){

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}