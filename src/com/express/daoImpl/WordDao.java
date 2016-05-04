package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.WordEntity;

/**
 * Created by Nvpiao on 2016/5/4 0004.
 */
public class WordDao extends BaseDao<WordEntity, Integer> {

    public WordDao() {
        super(WordEntity.class);
    }
}
