package com.xrq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 许瑞琪
 * Date  2025/7/9 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfessionalTitles {
    private Integer id;
    private String titleName;
    private String description;
}
