package sv.edu.catolica.booklore.SQLite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_BD = "booklore";

    public AdminSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        //TABLA roles
        BaseDeDatos.execSQL("create table roles(id_rol INTEGER primary key  autoincrement,rol varchar(50));");

        //TABLA logueo
        BaseDeDatos.execSQL("create table logueo(id_logueo INTEGER not null primary key autoincrement,username varchar(50),contrasena varchar(50)," +
                "id_rol int,foreign key (id_rol) references roles(id_rol));");

        //TABLA usuario
        BaseDeDatos.execSQL("create table usuario(id_usuario INTEGER not null primary key autoincrement,id_logueo int,nombre varchar(50)," +
                "apellido varchar(50),email varchar(60), foreign key (id_logueo) references logueo(id_logueo));");

        //TABLA libro
        BaseDeDatos.execSQL("create table libro(id_libro INTEGER not null primary key autoincrement,nombre varchar(50),editorial varchar(50)," +
                "isbn10 varchar(50),isbn13 varchar(50),edicion varchar(20),portada varchar(250),total_paginas int,\n" +
                "sinopsis varchar(500),rating int);");

        //TABLA estado
        BaseDeDatos.execSQL("create table estado(id_estado INTEGER not null primary key autoincrement,estado varchar(30));");

        //TABLA usuario_libros
        BaseDeDatos.execSQL("create table usuarios_libros(id_usuario int,id_libro int,id_estado int,foreign key (id_usuario) references usuario(id_usuario),\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_estado) references estado(id_estado));");

        //TABLA libreria
        BaseDeDatos.execSQL("create table libreria(id_libreria INTEGER not null primary key autoincrement,nombre varchar(50),ubicacion varchar(150)," +
                "telefono char(10),email varchar(60),web varchar(100));");

        BaseDeDatos.execSQL("create table libreria_libros(id_libreria int,id_libro int," +
                " foreign key (id_libreria) references libreria(id_libreria),foreign key (id_libro) references libro(id_libro));");

        BaseDeDatos.execSQL("create table leyendo(id_usuario int,id_libro int,pagina_actual int, foreign key (id_usuario) references usuario(id_usuario)," +
                "foreign key (id_libro) references libro(id_libro));");

        BaseDeDatos.execSQL("create table tag(id_tag INTEGER not null primary key autoincrement,nombre varchar(50));");

        BaseDeDatos.execSQL("create table libro_tag(id_libro int,id_tag int,foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_tag) references tag(id_tag));");

        BaseDeDatos.execSQL("create table comentario(id_comentario INTEGER not null primary key autoincrement,id_libro int,id_usuario int,comentario varchar(250),\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("create table frases(id_frase INTEGER not null primary key autoincrement,id_libro int,id_usuario int,frase varchar(250),foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("create table rating(id_rating INTEGER not null primary key autoincrement,id_libro int,id_usuario int,porcentaje int,foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("create table tipo_grupo(id_tipogrupo INTEGER not null primary key autoincrement,tipo varchar(50));");

        BaseDeDatos.execSQL("create table grupo(id_grupo INTEGER not null primary key autoincrement,id_libro int,id_usuario int,id_tipogrupo int,\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_usuario) references usuario(id_usuario),foreign key (id_tipogrupo) references tipo_grupo(id_tipogrupo));");

        BaseDeDatos.execSQL("alter table grupo add nombre_grupo varchar(30);");

        BaseDeDatos.execSQL("alter table grupo add imagen varchar(150);");

        BaseDeDatos.execSQL("alter table grupo add contrasena varchar(20);");

        BaseDeDatos.execSQL("alter table grupo add descripcion varchar(100);");

        BaseDeDatos.execSQL("create table grupo_usuarios(id_usuario int,id_grupo int,foreign key (id_grupo) references grupo(id_grupo)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("create table grupo_comentario(id_grupocomentario INTEGER not null primary key autoincrement,id_usuario int, comentario varchar(250)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("create table likes_comentario(id_like INTEGER not null primary key autoincrement,id_grupocomentario int, me_gusta int,dislike int," +
                "foreign key (id_grupocomentario) references grupo_comentario(id_grupocomentario));");

        BaseDeDatos.execSQL("create table cotizacion(id_cotizacion INTEGER not null primary key autoincrement,id_usuario int,id_libro int,fecha date,monto decimal(10,2),id_libreria int,\n" +
                "foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario),foreign key (id_libreria) references libreria(id_libreria));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

        BaseDeDatos.execSQL("drop table if exists roles");
        BaseDeDatos.execSQL("create table roles(id_rol INTEGER primary key  autoincrement,rol varchar(50));");

        //TABLA logueo
        BaseDeDatos.execSQL("drop table if exists logueo");
        BaseDeDatos.execSQL("create table logueo(id_logueo INTEGER not null primary key autoincrement,username varchar(50),contrasena varchar(50)," +
                "id_rol int,foreign key (id_rol) references roles(id_rol));");

        //TABLA usuario
        BaseDeDatos.execSQL("drop table if exists usuario");
        BaseDeDatos.execSQL("create table usuario(id_usuario INTEGER not null primary key autoincrement,id_logueo int,nombre varchar(50)," +
                "apellido varchar(50),email varchar(60));");

        //TABLA libro
        BaseDeDatos.execSQL("drop table if exists libro");
        BaseDeDatos.execSQL("create table libro(id_libro INTEGER not null primary key autoincrement,nombre varchar(50),editorial varchar(50)," +
                "isbn10 varchar(50),isbn13 varchar(50),edicion varchar(20),portada varchar(250),total_paginas int,\n" +
                "sinopsis varchar(500),rating int);");

        //TABLA estado
        BaseDeDatos.execSQL("drop table if exists estado");
        BaseDeDatos.execSQL("create table estado(id_estado INTEGER not null primary key autoincrement,estado varchar(30));");

        //TABLA usuario_libros
        BaseDeDatos.execSQL("drop table if exists usuarios_libros");
        BaseDeDatos.execSQL("create table usuarios_libros(id_usuario int,id_libro int,id_estado int,foreign key (id_usuario) references usuario(id_usuario),\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_estado) references estado(id_estado));");

        //TABLA libreria
        BaseDeDatos.execSQL("drop table if exists libreria");
        BaseDeDatos.execSQL("create table libreria(id_libreria INTEGER not null primary key autoincrement,nombre varchar(50),ubicacion varchar(150)," +
                "telefono char(10),email varchar(60),web varchar(100));");

        BaseDeDatos.execSQL("drop table if exists libreria_libros");
        BaseDeDatos.execSQL("create table libreria_libros(id_libreria int,id_libro int," +
                " foreign key (id_libreria) references libreria(id_libreria),foreign key (id_libro) references libro(id_libro));");

        BaseDeDatos.execSQL("drop table if exists leyendo");
        BaseDeDatos.execSQL("create table leyendo(id_usuario int,id_libro int,pagina_actual int, foreign key (id_usuario) references usuario(id_usuario)," +
                "foreign key (id_libro) references libro(id_libro));");

        BaseDeDatos.execSQL("drop table if exists tag");
        BaseDeDatos.execSQL("create table tag(id_tag INTEGER not null primary key autoincrement,nombre varchar(50));");

        BaseDeDatos.execSQL("drop table if exists libro_tag");
        BaseDeDatos.execSQL("create table libro_tag(id_libro int,id_tag int,foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_tag) references tag(id_tag));");

        BaseDeDatos.execSQL("drop table if exists comentario");
        BaseDeDatos.execSQL("create table comentario(id_comentario INTEGER not null primary key autoincrement,id_libro int,id_usuario int,comentario varchar(250),\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("drop table if exists frases");
        BaseDeDatos.execSQL("create table frases(id_frase INTEGER not null primary key autoincrement,id_libro int,id_usuario int,frase varchar(250),foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("drop table if exists rating");
        BaseDeDatos.execSQL("create table rating(id_rating INTEGER not null primary key autoincrement,id_libro int,id_usuario int,porcentaje int,foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("drop table if exists tipo_grupo");
        BaseDeDatos.execSQL("create table tipo_grupo(id_tipogrupo INTEGER not null primary key autoincrement,tipo varchar(50));");

        BaseDeDatos.execSQL("drop table if exists grupo");
        BaseDeDatos.execSQL("create table grupo(id_grupo INTEGER not null primary key autoincrement,id_libro int,id_usuario int,id_tipogrupo int,\n" +
                "foreign key (id_libro) references libro(id_libro),foreign key (id_usuario) references usuario(id_usuario),foreign key (id_tipogrupo) references tipo_grupo(id_tipogrupo));");

        BaseDeDatos.execSQL("alter table grupo add nombre_grupo varchar(30);");

        BaseDeDatos.execSQL("alter table grupo add imagen varchar(150);");

        BaseDeDatos.execSQL("alter table grupo add contrasena varchar(20);");

        BaseDeDatos.execSQL("alter table grupo add descripcion varchar(100);");

        BaseDeDatos.execSQL("drop table if exists grupo_usuarios");
        BaseDeDatos.execSQL("create table grupo_usuarios(id_usuario int,id_grupo int,foreign key (id_grupo) references grupo(id_grupo)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("drop table if exists grupo_comentario");
        BaseDeDatos.execSQL("create table grupo_comentario(id_grupocomentario INTEGER not null primary key autoincrement,id_usuario int, comentario varchar(250)," +
                "foreign key (id_usuario) references usuario(id_usuario));");

        BaseDeDatos.execSQL("drop table if exists likes_comentario");
        BaseDeDatos.execSQL("create table likes_comentario(id_like INTEGER not null primary key autoincrement,id_grupocomentario int, me_gusta int,dislike int," +
                "foreign key (id_grupocomentario) references grupo_comentario(id_grupocomentario));");

        BaseDeDatos.execSQL("drop table if exists cotizacion");
        BaseDeDatos.execSQL("create table cotizacion(id_cotizacion INTEGER not null primary key autoincrement,id_usuario int,id_libro int,fecha date,monto decimal(10,2),id_libreria int,\n" +
                "foreign key (id_libro) references libro(id_libro)," +
                "foreign key (id_usuario) references usuario(id_usuario),foreign key (id_libreria) references libreria(id_libreria));");
    }
}
