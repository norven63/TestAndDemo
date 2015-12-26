package com.qihoo.security.lite;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.qihoo.security.lite.ApkDownloadInfo;

import com.qihoo.security.lite.ApkDownloadInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig apkDownloadInfoDaoConfig;

    private final ApkDownloadInfoDao apkDownloadInfoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        apkDownloadInfoDaoConfig = daoConfigMap.get(ApkDownloadInfoDao.class).clone();
        apkDownloadInfoDaoConfig.initIdentityScope(type);

        apkDownloadInfoDao = new ApkDownloadInfoDao(apkDownloadInfoDaoConfig, this);

        registerDao(ApkDownloadInfo.class, apkDownloadInfoDao);
    }
    
    public void clear() {
        apkDownloadInfoDaoConfig.getIdentityScope().clear();
    }

    public ApkDownloadInfoDao getApkDownloadInfoDao() {
        return apkDownloadInfoDao;
    }

}