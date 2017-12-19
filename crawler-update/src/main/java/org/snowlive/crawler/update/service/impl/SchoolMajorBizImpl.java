package org.snowlive.crawler.update.service.impl;

import org.snowlive.crawler.update.entity.master.SchoolMajor;
import org.snowlive.crawler.update.mapper.master.SchoolInfoMapper;
import org.snowlive.crawler.update.mapper.master.SchoolMajorMapper;
import org.snowlive.crawler.update.service.IdCollegeBiz;
import org.snowlive.crawler.update.service.SchoolMajorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-16
 */
@Service
public class SchoolMajorBizImpl implements SchoolMajorBiz {

    private int count = 0;

    @Autowired
    private SchoolMajorMapper schoolMajorMapper;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Autowired
    private IdCollegeBiz idCollegeBiz;

    @Override
    public int updateMajor() {
        handler();
        return count;
    }

    private void handler() {
        schoolMajorMapper.listAll().forEach(entity -> {
            count += schoolMajorMapper.updateSchoolId(updateEntity(entity));
            System.out.println("count:" + count + "\n entity:" + entity.getId() + ":" + entity.getSchoolId());
        });

    }

    @Transactional
    protected SchoolMajor updateEntity(SchoolMajor entity) {
        entity.setSchoolId(schoolInfoMapper
                .findSchoolIdByName(idCollegeBiz
                        .getSchoolName(entity
                                .getId())));

        return entity;
    }
}
