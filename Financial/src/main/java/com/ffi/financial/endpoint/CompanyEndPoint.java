package com.ffi.financial.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffi.financial.handler.ConfigAppProperties;
import com.ffi.financial.service.CompanyService;

@RestController
@RequestMapping("/rest/Company/")
public class CompanyEndPoint {

	@Autowired
	CompanyService companyService;

	@Autowired
	ConfigAppProperties configAppProperties;

	@GetMapping(value = "/getCompany/{companyId}", produces = "application/json")
	@ResponseBody
	public ResponseJson<Response> getLead(@PathVariable final String companyId) {
		ResponseJson<Response> pocResponseJson = new ResponseJson<Response>();
		try {
			Response response = new Response();
			Map<String, Object> responseObject = new HashMap<String, Object>();
			responseObject.put("company", companyService.getCompany(companyId));
			response.setResponseObject(responseObject);
			pocResponseJson.setData(response);
			pocResponseJson.setStatusMessage(configAppProperties.getConfigValue("success.retrieved.msg"));
			pocResponseJson.setStatusCode(configAppProperties.getConfigValue("success.code"));
		} catch (Exception e) {
			pocResponseJson.setErrorMessage(e.getMessage());
		}
		return pocResponseJson;
	}

}
