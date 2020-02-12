package com.laoxing.chip.consumer.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 16:20
 */
public interface QRcodeService {

    void createQrcode(String msg, HttpServletResponse response);
}
