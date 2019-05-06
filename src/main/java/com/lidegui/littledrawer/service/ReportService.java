package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Report;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:23 2019/5/6
 */
public interface ReportService {

    public Report addReport(Report report);

    public int deleteReport(int reportId);

    public void AcceptReport(String topicName, int topicId);

    public List<Report> getAllReports();

    public List<Report> getReportsByTopic(String topicName);

    public Report getReportByTopicIdAndReporter(int topicId, int reporterId);

    public Report getReportByTopicNameAndTopicId(int topicId, String topicName);
}
