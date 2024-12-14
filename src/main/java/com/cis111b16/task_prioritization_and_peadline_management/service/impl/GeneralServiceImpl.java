package com.cis111b16.task_prioritization_and_peadline_management.service.impl;

import com.cis111b16.task_prioritization_and_peadline_management.mapper.GeneralMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;
import com.cis111b16.task_prioritization_and_peadline_management.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type General service.
 */
@Service
public class GeneralServiceImpl implements GeneralService {
    @Autowired
    private GeneralMapper generalMapper;

    @Override
    public General edit(General general) {
        generalMapper.edit(general);
        return  general;
    }

    @Override
    public General findByID(int taskid) {
        return  generalMapper.findByID(taskid);
    }
}
