package com.devocean.Balbalm.activity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devocean.Balbalm.activity.entity.dto.ActivityDto;
import com.devocean.Balbalm.activity.service.ActivityService;
import com.devocean.Balbalm.global.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {
	private final ActivityService activityService;
	private final JwtUtil jwtUtil;

	@GetMapping()
	public List<ActivityDto> getActivity(@RequestParam String token, @RequestParam LocalDate date) {
		return activityService.getActivities(jwtUtil.extractSocialId(token), date);
	}

	@GetMapping("/month")
	public List<Integer> getActivityDay(@RequestParam int month, @RequestParam int year, @RequestParam String token) {
		return activityService.getActivitiesInMonth(
			jwtUtil.extractSocialId(token), year, month);
	}
}
