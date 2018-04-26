package com.task.restproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ide;

    private String hash;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String dateModified;
    private String id;

    public Data(){
    }

    public Data(String hash, String format, String url, String title, String documentOf, String datePublished, String dateModified, String id) {
        this.hash = hash;
        this.format = format;
        this.url = url;
        this.title = title;
        this.documentOf = documentOf;
        this.datePublished = datePublished;
        this.dateModified = dateModified;
        this.id = id;
    }

    public Integer getIde() {
        return ide;
    }

    public void setIde(Integer ide) {
        this.ide = ide;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data:" + "\n"+
                "hash: '" + hash + '\'' +"\n"+
                "format: '" + format + '\'' +"\n"+
                "url: '" + url + '\'' +"\n"+
                "title: '" + title + '\'' + "\n"+
                "documentOf: '" + documentOf + '\'' + "\n"+
                "datePublished: '" + datePublished + '\'' +"\n"+
                "dateModified: '" + dateModified + '\'' +"\n"+
                "id: '" + id + '\'' ;
    }
}
