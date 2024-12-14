package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;

/**
 * The interface Bill pay service.
 */
public interface BillPayService {
    /**
     * Find by id bill pay.
     *
     * @param taskid the taskid
     * @return the bill pay
     */
    BillPay findByID(int taskid);

    /**
     * Edit bill pay.
     *
     * @param billPay the bill pay
     * @return the bill pay
     */
    BillPay edit(BillPay billPay);
}
