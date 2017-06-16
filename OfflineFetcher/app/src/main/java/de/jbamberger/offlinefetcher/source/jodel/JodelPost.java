package de.jbamberger.offlinefetcher.source.jodel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import de.jbamberger.offlinefetcher.DaoSession;
import de.jbamberger.offlinefetcher.JodelPostDao;

@Entity(
        active = true,
        indexes = {
                @Index(value = "id DESC")
        },
        generateGettersSetters = true,
        generateConstructors = true
)
public class JodelPost {

    @Id(autoincrement = true)
    private Long id;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
/** Used for active entity operations. */
@Generated(hash = 1199730255)
private transient JodelPostDao myDao;

@Generated(hash = 931315812)
public JodelPost(Long id) {
    this.id = id;
}

@Generated(hash = 317323159)
public JodelPost() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1958953239)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getJodelPostDao() : null;
}

    /*// name chosen by the user, not the filename
    @NotNull
    private String name;

    //absolute path to the file on disk
    @NotNull
    private String fileLocation;

    @NotNull
    private String mimeType;

    @NotNull
    private int type;

    @NotNull
    private Long localDateCreated;

    private Long locationId;

    @ToOne(joinProperty = "locationId")
    private Location location;

    private String comment;

    private String uniqueUrl;

    private String hashString;

    private Long dateCreated;

    private Long singleSeedId;

   *//* @ToOne(joinProperty = "singleSeedId")
    private SingleSeed singleSeed;

    private Long multiSeedId;

    @ToOne(joinProperty = "multiSeedId")
    private MultiSeed multiSeed;*//*

    private boolean deleted;

    private boolean completed;

    private String pdfLocation;*/

}
