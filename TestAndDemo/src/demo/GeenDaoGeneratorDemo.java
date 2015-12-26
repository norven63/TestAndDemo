package demo;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GeenDaoGeneratorDemo {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.qihoo.security.lite");
        addNote(schema);
        new DaoGenerator().generateAll(schema, "../");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("ApkDownloadInfo");

        note.addIdProperty();
        note.addIntProperty("taskId").notNull();
        note.addIntProperty("progress");
        note.addIntProperty("statu");
        note.addStringProperty("label");
        note.addStringProperty("url");
        note.addStringProperty("fileName");
        note.addStringProperty("filePath");
        note.addStringProperty("pkgName");
    }
}
