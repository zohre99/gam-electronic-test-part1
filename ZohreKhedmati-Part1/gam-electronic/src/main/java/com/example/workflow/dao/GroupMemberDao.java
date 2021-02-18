package com.example.workflow.dao;

import com.example.workflow.model.entity.GroupMemberEntity;
import com.example.workflow.model.response.GroupMemberResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMemberDao extends JpaRepository<GroupMemberEntity, Long> {

    @Query("select new com.example.workflow.model.response.GroupMemberResponse(g.id, g.groupName, g.username) from GroupMemberEntity g")
    List<GroupMemberResponse> getAll();

    @Query("select new com.example.workflow.model.response.GroupMemberResponse(g.id, g.groupName, g.username) from GroupMemberEntity g where g.id=:id")
    GroupMemberResponse getById(@Param("id") Long id);

}
