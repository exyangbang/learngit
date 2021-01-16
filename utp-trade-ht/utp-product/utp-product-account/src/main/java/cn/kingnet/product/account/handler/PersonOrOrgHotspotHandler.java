package cn.kingnet.product.account.handler;

import cn.kingnet.product.account.service.inner.manage.PersonOrOrgHotspotService;
import cn.kingnet.product.api.account.IPersonOrOrgHotspotHandler;
import cn.kingnet.utp.product.common.dto.manage.AccountInfoDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.PersonOrOrgHotspotReqDTO;
import cn.kingnet.utp.trade.common.dto.account.PersonOrOrgHotspotRespDTO;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 建立个人/企业的客户热点信息
 * @Author : linkaigui
 * @Create : 2019/3/16 18:39
 */
@RestController
@RequestMapping("/innerAccount/personOrOrgHotspot")
@Slf4j
public class PersonOrOrgHotspotHandler extends DefaultFeginExceptionHandler implements IPersonOrOrgHotspotHandler {

	@Autowired
	private PersonOrOrgHotspotService personOrOrgHotspotService;

	@Override
	public PersonOrOrgHotspotRespDTO addPersonOrOrgHotspot(@RequestBody PersonOrOrgHotspotReqDTO personOrOrgHotspotReqDTO) {
		AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
		accountInfoDTO.setId(personOrOrgHotspotReqDTO.getId());
		accountInfoDTO.setAccount(personOrOrgHotspotReqDTO.getAccount());
		accountInfoDTO.setCode(personOrOrgHotspotReqDTO.getCode());
		accountInfoDTO.setType(personOrOrgHotspotReqDTO.getType());
		accountInfoDTO.setName(personOrOrgHotspotReqDTO.getName());
		accountInfoDTO.setFundAccount(personOrOrgHotspotReqDTO.getFundAccount());
		ServerResponseDTO serverResponseDTO = personOrOrgHotspotService.addPersonOrOrgHotspot(accountInfoDTO, 2);
		PersonOrOrgHotspotRespDTO resp = PersonOrOrgHotspotRespDTO.builder().build();
		resp.setStatus(serverResponseDTO.getStatus());
		resp.setMessage(serverResponseDTO.getMessage());
		return resp;
	}
}
