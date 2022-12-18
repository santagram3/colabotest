
package WORKERS.Boast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.Boast.dto.BoastDTO;
import WORKERS.Boast.mapper.BoastMapper;
import WORKERS.Boast.model.Boast;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoastService {
	
	@Autowired
	private BoastMapper boastMapper;

	public List<Boast> boastList() throws Exception {
		System.out.println("list 서비스 도착");
		List<Boast> bl = boastMapper.getBoastList();
		System.out.println("list 서비스 완료");
		return bl;
	}
}
