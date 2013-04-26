package be.webelite.iconview;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
/*
 * Copyright (C) 2013 Marzpet Vardanyan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 * @author Marzpet Vardanyan | webelite.be | info@webelite.be
 * @version 1.0
 * 
 * this class is an extension of the android {@link TextView} widget,
 * with the entypo typeface applied to it by default.
 * 
 * a custom attribute has been added for easy icon selection
 */

public class IconView extends TextView {
	Typeface entypo;	
	public IconView(Context context)
    {
        super(context);
        init(context, null);
    }
    public IconView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }
    public IconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);       
        init(context, attrs);
    }
    
    protected void init(Context context, AttributeSet attrs){
        
    	// TODO check attribute value
        // set correct unicode character as text
    	TypedArray a 				= context.obtainStyledAttributes(attrs,be.webelite.entypoview.R.styleable.icon);
		String icon_name 			= a.getString(be.webelite.entypoview.R.styleable.icon_icon_name);
		Icon icon 					= Icon.valueOf(icon_name);
		a.recycle();
        
		this.setIcon(icon);
    	
    	this.entypo = getFontFromRes(be.webelite.entypoview.R.raw.entypo, context);
    	this.setTypeface(this.entypo);
    }
    
	protected Typeface getFontFromRes(int resource, Context context)
    { 
        Typeface tf = null;
        InputStream is = null;
        try {
            is = getResources().openRawResource(resource);
        }
        catch(NotFoundException e) {
            Log.e("getFontFromRes", "Could not find font in resources!");
        }

        String outPath = context.getCacheDir() + "/tmp" + System.currentTimeMillis() + ".raw";

        try
        {
            byte[] buffer = new byte[is.available()];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));

            int l = 0;
            while((l = is.read(buffer)) > 0)
                bos.write(buffer, 0, l);

            bos.close();

            tf = Typeface.createFromFile(outPath);

            // clean up
            new File(outPath).delete();
        }
        catch (IOException e)
        {
            Log.e("getFontFromRes", "Error reading in font!");
            return null;
        }

        Log.d("getFontFromRes", "Successfully loaded font.");

        return tf;      
    }
    /**
     * set icon 
     */
	public void setIcon(Icon icon){
		this.setText( Character.toString( (char) icon.unicode_value) );
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	    
	}
	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
	}

}
