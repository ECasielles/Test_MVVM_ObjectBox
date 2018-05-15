package com.mercacortex.testbinding.mvvm.model;

import android.databinding.Bindable;

import com.mercacortex.testbinding.BR;
import com.mercacortex.testbinding.base.BaseModel;
import com.mercacortex.testbinding.mvvm.model.db.converter.DateTimeConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;


@Entity
public class Model extends BaseModel {

    @Id
    private long id;

    public String text;
    public String title = "titulo";
    public String description = "descripcion";
    public String category = "categoria";

    @Convert(converter = DateTimeConverter.class, dbType = Long.class)
    public DateTime date;
    public int icon;

    public Model() { }

    public Model(String text, int icon) {
        this.date = DateTime.now();
        this.text = text;
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyChange();
    }

    @Bindable
    public String getText() {
        return text;
    }

    @Bindable
    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String getDate() {
        return DateTimeFormat.forPattern("HH:mm dd/MM/yyyy").print(date);
    }

    @Bindable
    public void setDate(DateTime date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

}
