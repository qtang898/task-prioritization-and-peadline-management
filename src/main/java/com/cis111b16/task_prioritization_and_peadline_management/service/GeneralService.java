package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;

public interface GeneralService {
    General edit(General general);

    General findByID(int taskid);
}
