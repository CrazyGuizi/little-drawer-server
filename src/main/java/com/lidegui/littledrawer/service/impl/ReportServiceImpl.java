package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Report;
import com.lidegui.littledrawer.dao.ReportDao;
import com.lidegui.littledrawer.service.ReportService;
import com.lidegui.littledrawer.util.ReportTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:29 2019/5/6
 */

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao mReportDao;

    @Override
    public Report addReport(Report report) {
        if (mReportDao.insert(report) > 0) {
            return mReportDao.findReportById(report.getId());
        }

        return null;
    }

    @Override
    public int deleteReport(int reportId) {
        return mReportDao.deleteById(reportId);
    }

    @Override
    public void AcceptReport(String topicName, int topicId) {

    }

    @Override
    public List<Report> getAllReports() {
        return mReportDao.findAllReports();
    }

    @Override
    public List<Report> getReportsByTopic(String topicName) {
        return mReportDao.findReportsByTopic(topicName);
    }

    @Override
    public Report getReportByTopicIdAndReporter(int topicId, int reporterId) {
        return mReportDao.findReportByTopicIdAndReporter(topicId, reporterId);
    }

    @Override
    public Report getReportByTopicNameAndTopicId(int topicId, String topicName) {
        return mReportDao.findReportByTopicNameAndTopicId(topicId, topicName);
    }
}
