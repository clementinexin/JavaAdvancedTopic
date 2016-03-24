#language: zh-CN
#"zh-CN": {
#    "but": "*|但是<",
#    "and": "*|而且<|并且<|同时<",
#    "then": "*|那么<",
#    "when": "*|当<",
#    "name": "Chinese simplified",
#    "native": "简体中文",
#    "feature": "功能",
#    "background": "背景",
#    "scenario": "场景|剧本",
#    "scenario_outline": "场景大纲|剧本大纲",
#    "examples": "例子",
#    "given": "*|假如<|假设<|假定<"
#  },
功能: 验证Cucumber依赖

  场景: 检查Cucumber启动正常
    假如安装正常
    当执行hello
    """
    hello
    """
    那么得到world
    """
    world
    """


