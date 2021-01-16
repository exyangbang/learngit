package com.scenetec.upf.operation.service.country;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.country.CountryDO;

import java.util.List;

public interface CountryService {
    Page<CountryDO> getCountList();
}
