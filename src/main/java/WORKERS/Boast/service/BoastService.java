
package WORKERS.Boast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WORKERS.Boast.mapper.BoastMapper;
@Service
public class BoastService {
	@Autowired
	private BoastMapper boastMapper;

	public BoastService(BoastMapper boastMapper) {
		this.boastMapper = boastMapper;
	}
}
