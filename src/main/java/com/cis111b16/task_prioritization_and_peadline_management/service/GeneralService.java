package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;

/**
 * The interface General service.
 */
public interface GeneralService {
    /**
     * Edit general.
     *
     * @param general the general
     * @return the general
     */
    General edit(General general);

    /**
     * Find by id general.
     *
     * @param taskid the taskid
     * @return the general
     */
    General findByID(int taskid);
}
