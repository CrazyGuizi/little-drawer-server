package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:12 2019/5/6
 */
public interface ReportDao {
    public int insert(Report report);

    public int deleteById(int reportId);

    public int updateReport(Report report);

    public Report findReportById(int reportId);

    public List<Report> findAllReports();

    public List<Report> findReportsByTopic(String topicName);

    public Report findReportByTopicIdAndReporter(@Param("topicId") int topicId,
                                    @Param("reporterId") int reporterId);

    public Report findReportByTopicNameAndTopicId(@Param("topicId") int topicId,
                                    @Param("topicName") String topicName);

}
